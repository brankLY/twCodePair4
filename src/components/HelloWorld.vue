<template>
  <div>
    <!-- <blog-header></blog-header> -->
    <hr/>
    <div>
      初始化长:<input type="text" v-model="initInfoVo.initListRow" placeholder="请输入初始化长" />
      <br/>
      初始化宽<input type="text" v-model="initInfoVo.initListCol" placeholder="请输入初始化宽" />
      <br/>
      <button v-on:click="init">初始化</button>
      <br/>
      情况：<textarea cols="5" rows="10" v-model="initResponseResult"></textarea>
    </div>
    <div>
      实例化:<input type="text" v-model="instantiateInfo.reqInitNums" placeholder="请输入实例化数据" />
      <br/>
      <button v-on:click="instantiate">实例化</button>
      <br/>
      情况：<textarea cols="5" rows="10" v-model="instantiateResponseResult"></textarea>
    </div>
    <div>
      <button v-on:click="next">next</button>
      <br/>
      情况：<textarea cols="5" rows="10" v-model="nextResponseResult"></textarea>
    </div>
    <div>
    <el-form>
    <el-form-item lable="任务列表">
        <el-row>
            <el-col v-for="(item, index) in nextResponseResult" :offset="4" v-bind:key="item">
              <el-col v-for="subItem in item" :offset="4" v-bind:key="subItem">
                 {{subItem}}{{index}}
            </el-col>
            </el-col>
        </el-row>
    </el-form-item>
    </el-form>
    </div>

    <div>
      时间频率:<input type="text" v-model="startInfoVo.reqTime" placeholder="请输入时间频率(间隔毫秒)" />
      <br/>
      <button v-on:click="start">start</button>
      <br/>
    <el-form>
    <el-form-item lable="任务列表">
        <el-row>
            <el-col v-for="(item, index) in startResponseResult" :offset="4" v-bind:key="item">
              <el-col v-for="subItem in item" :offset="4" v-bind:key="subItem">
                 {{subItem}}{{index}}
            </el-col>
            </el-col>
        </el-row>
    </el-form-item>
    </el-form>
    </div>
    <hr/>
  </div>
</template>

<script>
import Qs from 'qs'
export default {
  name: 'HelloWorld',
  data () {
    return {
      initInfoVo: { initListRow: '', initListCol: '' },
      startInfoVo:{ reqTime: ''},
      instantiateInfo: {reqInitNums: ''},
      nextResponseResult: [[]],
      initResponseResult: [],
      instantiateResponseResult: [],
      startResponseResult: [[]]
    }
  },
  methods: {
    init () {
      var req = Qs.stringify({"initListRow":this.initInfoVo.initListRow,"initListCol":this.initInfoVo.initListCol});
      this.$axios
        .post('/init', req, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
        .then(successResponse => {
          this.initResponseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          }
        })
        .catch(failResponse => {})
    },
    start(){
      var req = Qs.stringify({"reqTime":this.startInfoVo.reqTime});
      while(1){
        this.$axios
        .post('/start', req, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
        .then(successResponse => {
          this.startResponseResult = successResponse.data
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          }
        })
        .catch(failResponse => {})
      }
    },
    instantiate (){
      var req = Qs.stringify({"reqInitNums":this.instantiateInfo.reqInitNums});
      this.$axios
        .post('/instantiate', req, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
        .then(successResponse => {
          this.instantiateResponseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          }
        })
        .catch(failResponse => {})
    },
    next(){
      this.$axios
        .get('/next', {}, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
        .then(successResponse => {
          this.nextResponseResult = successResponse.data
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          }
        })
        .catch(failResponse => {})
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
