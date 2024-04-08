/** @format */

//인증 처리를 지원하기 위한 유틸리티 함수들
//백엔드API 이용한 인증은 적용하지 않기 때문에 코드 수준에서 정적인 사용자 정보 작성
//정적인 사용자 정보담은 배열
const staticUsers = [
  // TODO. 백엔드 API 인증 서버를 이용하도록 변경
  { userid: "user1", password: "1234", roles: ["users"] },
  { userid: "user2", password: "1234", roles: ["users"] },
  { userid: "admin", password: "1234", roles: ["users", "admins"] },
];

//각 경로로 진입하기 위해 어떤 역할을 보유해야 하는지 담은 배열
const pathsToRoles = [
  { path: "/", roles: ["everybody"] },
  { path: "/login", roles: ["everybody"] },
  { path: "/users", roles: ["users", "admins"] },
  { path: "/admins", roles: ["admins"] },
];

//localStorage에 사용자 정보 저장
const setUserInfo = (userInfo) => {
  if (userInfo && userInfo.authenticated) {
    // TODO. JWT 페이로드 정보도 JSON 문자열을 Base64로 인코딩한 구조
    //localStorage는 문자열만 저장할 수 있으므로 객체를 JSON문자열로 변환하고 다시 Base64 인코딩해 저장
    // setItem 키-값 쌍을 보관
    // btoa() 메서드는 문자열의 각 문자가 이진 데이터의 바이트 단위로 처리되는 이진 문자열을 Base64로 인코딩한 ASCII 문자열을 생성합니다.
    window.localStorage.setItem("userInfo", btoa(JSON.stringify(userInfo)));
  } else {
    // removeItem 키와 해당 값 삭제
    //userInfo가 null이면 로컬 스토리지 삭제
    window.localStorage.removeItem("userInfo");
  }
};

//localStorage에 저장된 사용자 정보 읽어오기
const getUserInfo = () => {
  // getItem(key) 키에 해당하는 값 가져온다.
  let strUserInfo = window.localStorage.getItem("userInfo");
  if (!strUserInfo) {
    return { authenticated: false };
  } else {
    // atob() 함수는 Base64 인코딩된 문자열 데이터를 디코딩합니다.
    // ASCII 값 0부터 31까지의 제어 문자처럼 통신에 사용하면 문제가 발생할 수 있는 데이터를 btoa()로 인코딩해 전송하고,
    // 받는 쪽에서는 atob()로 디코딩하면 문제 없이 원래 데이터를 가져올 수 있습니다.
    return JSON.parse(window.atob(strUserInfo));
  }
};

const loginProcess = (userid, password, successCallback, failCallback) => {
  //이 부분은 백엔드 API 인증 서버와 HTTP로 통신해 인증 처리해야 한다.
  const user = staticUsers.find(
    //인자로 전달받은 ID, PWD를 이용해 정적인 사용자 조회해 일치하는 정보 있는지 확인
    (u) => u.userid === userid && u.password === password
  );
  if (user) {
    let userInfo = {
      authenticated: true,
      userid: user.userid,
      roles: user.roles,
    };
    setUserInfo(userInfo); //로컬 스토리지에 userInfo 사용자 정보 값 저장
    successCallback(); //로그인 성공시 호출할 함수
  } else {
    if (failCallback) failCallback(); //로그인 실패시 호출할 함수
  }
};

const logoutProcess = (callback) => {
  setUserInfo(null); //로컬 스토리지에 저장된 사용자 정보 삭제
  callback();
};

//경로와 사용자 정보의 role을 기반으로 접근 허가 여부 결정(true/false)
//요청된 경로(reqPath)를 인자로 전달받아 현재의 사용자가 이 경로에 접근할 권한이 있는 사용자인지 확인 후 true/false 리턴
const isMatchToRoles = (reqPath) => {
  //{path:"/", roles: ["everybody"]}
  const path = pathsToRoles.find((pr) => pr.path === reqPath);
  //경로가 없다면 접근 불가
  if (!path) return false;

  const userInfo = getUserInfo();

  //인증되지 않았다면 everybody가 지정된 경로만 접근 가능
  if (userInfo.authenticated === false) {
    return path.roles.find((p) => p === "everybody") ? true : false;
  } else {
    //인증이 되었다면 userInfo와 roles와 path.roles에 동일한 것 체크
    let isAccessible = false;
    if (path.roles.indexOf("everybody") > -1) {
      isAccessible = true;
    } else {
      // for (let i in userInfo.roles.length) {
      for (let i = 0; i < userInfo.roles.length; i++) {
        let role = userInfo.roles[i];
        const index = path.roles.indexOf(role);
        if (index >= 0) {
          isAccessible = true;
          break;
        }
      }
    }

    return isAccessible;
  }
};

export { isMatchToRoles, loginProcess, logoutProcess, getUserInfo };
