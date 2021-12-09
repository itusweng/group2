<template>
  <div>
    <!--begin::Dashboard-->
    <div class="card card-custom gutter-b card-stretch">
      <div class="card-header border-0">
        <h3 class="card-title font-weight-bolder text-dark">Training Info</h3>
      </div>
      <div class="card-body pt-2">
        <b-row>
          <b-col md="3">
            <img
                src="https://picsum.photos/600/300/?image=56"
                class="w-100"
                alt=""
            />
          </b-col>
          <b-col md="3"
          >Yapı Kredi Mobil Uygulaması iOS-Android Aktarım-UE/001-21</b-col
          >
          <b-col md="3">
            <div>Start Date: 16 EYL 2021 00:00</div>
            <div>End Date: 31 ARA 2021 00:00</div>
          </b-col>
          <b-col md="3">
            <h2>Progress</h2>
            <Widget13></Widget13>
          </b-col>
        </b-row>
      </div>
    </div>

    <LessonList></LessonList>
  </div>
</template>

<script>
import Widget13 from '@/view/components/training/TrainingProgress';
import LessonList from '@/view/components/training/LessonList';

export default {
  name: 'dashboard',
  components: {
    Widget13,
    LessonList
  },
  data() {
    return {};
  },
};
</script>
