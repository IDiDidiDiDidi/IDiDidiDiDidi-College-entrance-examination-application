<template>
    <div id="Software" class="container">
        <div class="row">
            <div id="left" class="col-md-4 col-xs-12">
                <ul class="left-container wow bounceInLeft">
                    <p>汽车吊</p>
                    <li v-for="(item,index) in tonnageList" :key="index">
                        <router-link :to=item.path @click.native="refresh">
                            {{item.name}}
                        </router-link>
                    </li>
                </ul>
            </div>
            <div id="right" class="col-md-8 col-xs-12  wow bounceInRight">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>
<script>
import { WOW } from "wowjs";
export default {
    name: 'Software',
    data(){
        return{
            // 按照吨位分类 的List
            // path 后期将进行拼接 后面传 8t、10t 等信息
            tonnageList: [
                {
                    path: '/software/smartTown?t=8',
                    name: '8吨汽车吊'
                },{
                    path: '/software/smartTown?t=10',
                    name: '10吨汽车吊'
                },{
                    path: '/software/smartTown?t=12',
                    name: '12吨汽车吊'
                },{
                    path: '/software/smartTown?t=16',
                    name: '16吨汽车吊'
                },{
                    path: '/software/smartTown?t=18',
                    name: '18吨汽车吊'
                },{
                    path: '/software/smartTown?t=20',
                    name: '20吨汽车吊'
                }
            ]
        }
    },
    mounted() {
        var wow = new WOW();
        wow.init();
    },
    methods:{
　　　　refresh:function(){
　　　　　　this.$router.go(0);  
　　　　}
　　}
}
</script>
<style scoped>
#left{
    margin: 50px 0;
}
.left-container{
    width: 60%;
    margin: 0 auto;
    border: 1px solid #474747;
    border-radius: 5px;
}
.left-container>p{
    text-align: center;
    line-height: 45px;
    padding: 0;
    margin: 0;
    background: #474747;
    color: #fff;
    font-size: 18px;
    font-weight: bold;
}
.left-container>li {
  text-align: center;
  height: 38px;
  line-height: 38px;
  margin: 0;
  border-top: 1px solid #474747;
}
.left-container>li>a{
    text-decoration: none;
}
.left-container>li:hover{
    background: #928989;
}
#right{
    padding: 50px 0;
}
@media screen and (max-width: 768px){
    #right{
        padding: 15px;
    }
}
</style>

