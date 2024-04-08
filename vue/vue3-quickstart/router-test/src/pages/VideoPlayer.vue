<!-- @format -->
<!-- 영상을 플레이하는 컴포넌트 모달로 화면에 나타나기 때문에 컴포넌트 닫기 전까지는 화면 기능 사용 불가 -->
<!-- youtube-vue3 컴포넌트 이용해 유투브 영상 플레이 -->
<!-- 현재 플레이 중 영상이 끝나서 youtube-vue3 컴포넌트의 ended 이벤트 발생하면 다음 영상 플레이 -->
<!-- 영상 플레이 도중 중지, 닫기 버튼 클릭 시 /videos 경로로 이동하면서 플레이어 닫기 -->
<template lang="">
  <div class="modal">
    <div class="box">
      <div class="heading">
        <span class="title">::{{ videoInfo.video.title }}</span>
        <span class="category">({{ videoInfo.video.category }})</span>
        <span class="float-end badge bd-secondary pointer" @click="stopVideo">
          닫기X</span
        >
      </div>
      <div class="player">
        <YoutubeVue3
          ref="playerRef"
          :videoid="videoInfo.video.id"
          :autoplay="1"
          :controls="1"
          @ended="playNext"
        />
      </div>
      <div>
        <div>
          <i class="fa fa-backward ml-2 pointer" @click="playPrev"></i>
          <i class="fa fa-stop ml-2 pointer" @click="stopVideo"></i>
          <i class="fa fa-forward ml-2 pointer" @click="playNext"></i>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { reactive, ref, inject } from "vue";
import { onBeforeRouteUpdate, useRoute, useRouter } from "vue-router";
import { YoutubeVue3 } from "youtube-vue3";
export default {
  name: "VideoPlayer",
  components: { YoutubeVue3 },
  setup() {
    // App.vue의 읽기 공용 데이터를 inject를 통해 가져온다.
    const videos = inject("videos");
    const playerRef = ref(null); //youtube-vue3 컴포넌트 제공
    const currentRoute = useRoute();
    const router = useRouter();

    //현재 라우트 정보의 id와 일치하는 영상 찾아서 해당 객체 생성
    // let videoInfo = reactive({
    //   //video의 정보는 버튼의 이벤트에 따라 변경된다.
    //   //반응성에 의해 다시 렌덜링되면서 새로운 영상 플레이
    //   video: videos.find((v) => v.id === currentRoute.params.id),
    // });

    let videoInfo, currentIndex, prevVideoId, nextVideoId;
    videoInfo = reactive({
      video: videos.find((v) => v.id === currentRoute.params.id),
    });

    const getnavId = (to) => {
      videoInfo.video = videos.find((v) => v.id === to.params.id);
      currentIndex = videos.findIndex((v) => v.id === videoInfo.video.id);
      prevVideoId = videos[currentIndex - 1]
        ? videos[currentIndex - 1].id
        : null;
      nextVideoId = videos[currentIndex + 1]
        ? videos[currentIndex + 1].id
        : null;
    };

    //마운트되었을 때 현재의 라우트 정보를 이용해 이전, 다음 ID 획득
    //최초 마운드될때의 처리를 위해 한번 호출
    getnavId(currentRoute);

    const stopVideo = () => {
      playerRef.value.player.stopVideo();
      router.push({ name: "videos" });
    };

    //@ended 끝나면 다음것 실행
    const playNext = () => {
      //다음곡을 플레이하는 경로로 내비게이션뿐만 아니라 플레이할 비디오까지 함께 변경
      // const index = videos.findIndex((v) => v.id === videoInfo.video.id);
      // const nextVideo = videos[index + 1];
      if (nextVideoId) {
        //nextVideoId, nextVideo.id => nextVideoId
        // videoInfo.video = nextVideo;
        router.push({ name: "videos/id", params: { id: nextVideoId } });
      } else {
        // videoInfo.video = videos[0];
        router.push({ name: "videos/id", params: { id: nextVideo[0].id } });
      }
    };

    const playPrev = () => {
      // const index = videos.findIndex((v) => v.id === videoInfo.video.id);
      // const prevVideo = videos[index - 1];
      if (prevVideoId) {
        // videoInfo.video = prevVideo;
        // router.push("/videos/" + prevVideo.id);
        router.push({ name: "videos/id", params: { id: prevVideoId } });
      }
    };

    //컴포넌트가 마운드될때와 라우트가 변경될때 이전 영상 ID, 다음 영상 ID와 플레이할 영상 정보를 변경해줘야한다.
    onBeforeRouteUpdate((to) => {
      getnavId(to);
    });
    return { videoInfo, playerRef, stopVideo, playNext, playPrev };
  },
};
</script>
<style scoped>
.modal {
  display: block;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.4);
}
.box {
  background-color: white;
  margin: 80px auto;
  max-width: 500px;
  min-width: 100px;
  min-height: 350px;
  font: 13px "verdana";
  padding: 10px 10px 10px 10px;
}
.box div {
  padding: 0;
  display: block;
  margin: 10px 0 0 0;
}
.box .heading {
  background: #33a17f;
  font-weight: 300;
  text-align: left;
  color: #fff;
  margin: 5px 0 5px 0;
  padding: 10px;
  min-width: 200px;
  max-width: 500px;
}
.box .player {
  background: white;
}
.pointer {
  cursor: pointer;
}
</style>
