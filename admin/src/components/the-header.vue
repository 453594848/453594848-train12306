<template>
  <a-layout-header class="header">
    <div class="logo">
      <router-link style="color: white; font-size: 18px" to="/welcome">
        JAVA12306-控制台界面
      </router-link>
    </div>
    <div style="float: right; color: white;">
      您好：{{ member.mobile }} &nbsp;&nbsp;
      <router-link style="color: white;" to="/login">
        退出登录
      </router-link>
    </div>
    <a-menu
        v-model:selectedKeys="selectedKeys"
        :style="{ lineHeight: '64px' }"
        mode="horizontal"
        theme="dark"
    >


    </a-menu>
  </a-layout-header>
</template>

<script>
import {defineComponent, ref, watch} from 'vue';
import store from "@/store";
import router from '@/router'

export default defineComponent({
  name: "the-header-view",
  setup() {
    let member = store.state.member;
    const selectedKeys = ref([]);

    watch(() => router.currentRoute.value.path, (newValue) => {
      console.log('watch', newValue);
      selectedKeys.value = [];
      selectedKeys.value.push(newValue);
    }, {immediate: true});
    return {
      member,
      selectedKeys
    };
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.logo {
  float: left;
  height: 31px;
  width: 150px;
  color: white;
  font-size: 20px;
}
</style>
