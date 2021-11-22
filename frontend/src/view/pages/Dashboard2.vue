<template>
  <div>
    <!--begin::Dashboard-->
    <div class="row">
<!--      <div class="col-xl-12">
        <Eymen age="3424" @yasDegisti="assignCount" />
      </div>-->


      <b-input type="text" v-model="user.name" />
      <b-input type="text" v-model="user.surname" />

      <b-button @click="submit">
        Submit
      </b-button>
    </div>

  </div>
</template>

<script>
// import Eymen from './Eymen';

export default {
  components: {
    //Eymen
  },
  data() {
    return {
      inputText: 'Ertuğrul',
      open: true,
      count: 0,
      user: {
        name: 'Ertuğrul',
        surname: 'BEKTİK'
      },
      fruits: ['Elma', 'armut', 'ayva', 'kiraz'],
      users: [
        {
          name: 'Ertuğrul',
          age: 22
        },
        {
          name: 'Eymen',
          age: 21
        },
        {
          name: 'Fatma',
          age: 18
        }
      ]
    };
  },
  created() {
    //this.fetchUser();
  },
  methods: {
    submit(){
      console.log(this.user);
    },
    assignCount(yeniYaş){
      this.count = yeniYaş
    },
    hello() {
      console.log('Hello');
    },
    fetchUser() {
      // User verisi çekiliyo
      const userData = {};

      this.user = userData;
    }
  },
  computed: {
    x() {
      if (this.fruits.length > 10) {
        return '10 dan büyük';
      } else {
        return '10 dan küçük';
      }
    }
  },
  watch: {
    inputText(yeni) {
      console.log(yeni);
    }
  }
};
</script>
