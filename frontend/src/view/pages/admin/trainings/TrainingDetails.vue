<template>
  <div>
    <!--begin::Card-->
    <div class="card card-custom gutter-b">
      <div class="card-body">
        <!--begin::Details-->
        <div class="d-flex mb-9">
          <!--begin: Pic-->
          <div class="flex-shrink-0 mr-7 mt-lg-0 mt-3">
            <img
              src="https://picsum.photos/600/300/?image=22"
              alt="image"
              style="max-width: 300px"
            />
          </div>
          <!--end::Pic-->

          <!--begin::Info-->
          <div class="flex-grow-1">
            <!--begin::Title-->
            <div class="d-flex justify-content-between flex-wrap mt-1">
              <div class="d-flex mr-3">
                <a
                  href="#"
                  class="
                    text-dark-75 text-hover-primary
                    font-size-h5 font-weight-bold
                    mr-3
                  "
                >
                  {{ activeTraining.title }}
                </a>
              </div>

              <div class="my-lg-0 my-3">
                <b-button variant="light-primary">Update</b-button>
              </div>
            </div>
            <!--end::Title-->

            <!--begin::Content-->
            <div class="d-flex flex-wrap justify-content-between mt-1">
              <div class="d-flex flex-column flex-grow-1 pr-8">
                <div class="d-flex flex-wrap mb-4">
                  <a
                    href="#"
                    class="
                      text-dark-50 text-hover-primary
                      font-weight-bold
                      mr-lg-8 mr-5
                      mb-lg-0 mb-2
                    "
                  >
                    <i class="flaticon2-calendar-3 mr-2 font-size-lg"></i>
                    Trainer: {{ activeTraining.instructor.first_name }}
                    {{ activeTraining.instructor.last_name }}
                  </a>
                  <a
                    href="#"
                    class="text-dark-50 text-hover-primary font-weight-bold"
                  >
                    <i class="flaticon2-edit mr-2 font-size-lg"></i>
                    Created By: {{ activeTraining.user_created.first_name }}
                    {{ activeTraining.user_created.last_name }}
                  </a>
                </div>

                <span class="font-weight-bold text-dark-50">
                  {{ activeTraining.description }}
                </span>
              </div>
            </div>
            <!--end::Content-->
          </div>
          <!--end::Info-->
        </div>
        <!--end::Details-->

        <div class="separator separator-solid"></div>

        <!--begin::Items-->
        <div class="d-flex align-items-center flex-wrap mt-8">
          <!--begin::Item-->
          <div class="d-flex align-items-center flex-lg-fill mr-5 mb-2">
            <span class="mr-4">
              <i
                class="
                  flaticon-presentation
                  display-4
                  text-muted
                  font-weight-bold
                "
              ></i>
            </span>
            <div class="d-flex flex-column text-dark-75">
              <span class="font-weight-bolder font-size-sm">Type</span>
              <span class="font-weight-bolder font-size-h5">
                {{ activeTraining.isOnline ? 'Online' : 'Offline' }}
              </span>
            </div>
          </div>
          <!--end::Item-->

          <!--begin::Item-->
          <div class="d-flex align-items-center flex-lg-fill mr-5 mb-2">
            <span class="mr-4">
              <i
                class="flaticon-confetti display-4 text-muted font-weight-bold"
              ></i>
            </span>
            <div class="d-flex flex-column text-dark-75">
              <span class="font-weight-bolder font-size-sm">
                Registered User
              </span>
              <span class="font-weight-bolder font-size-h5">175</span>
            </div>
          </div>
          <!--end::Item-->

          <div class="d-flex align-items-center flex-lg-fill mr-5 mb-2">
            <span class="mr-4">
              <i
                class="flaticon-file-2 display-4 text-muted font-weight-bold"
              />
            </span>
            <div class="d-flex flex-column text-dark-75">
              <span class="font-weight-bolder font-size-sm">Lesson</span>
              <span class="font-weight-bolder font-size-h5">{{lessons.length}}</span>
            </div>
          </div>

          <!--begin::Item-->
          <div class="d-flex align-items-center flex-lg-fill mb-2 float-left">
            <span class="mr-4">
              <i
                class="flaticon-network display-4 text-muted font-weight-bold"
              ></i>
            </span>
            <div class="symbol-group symbol-hover">
              <div
                class="symbol symbol-30 symbol-circle"
                data-toggle="tooltip"
                title="Mark Stone"
              >
                <img alt="Pic" src="media/users/300_25.jpg" />
              </div>
              <div
                class="symbol symbol-30 symbol-circle"
                data-toggle="tooltip"
                title="Charlie Stone"
              >
                <img alt="Pic" src="media/users/300_19.jpg" />
              </div>
              <div
                class="symbol symbol-30 symbol-circle"
                data-toggle="tooltip"
                title="Luca Doncic"
              >
                <img alt="Pic" src="media/users/300_22.jpg" />
              </div>
              <div
                class="symbol symbol-30 symbol-circle"
                data-toggle="tooltip"
                title="Nick Mana"
              >
                <img alt="Pic" src="media/users/300_23.jpg" />
              </div>
              <div
                class="symbol symbol-30 symbol-circle"
                data-toggle="tooltip"
                title="Teresa Fox"
              >
                <img alt="Pic" src="media/users/300_18.jpg" />
              </div>
              <div class="symbol symbol-30 symbol-circle symbol-light">
                <span class="symbol-label font-weight-bold">5+</span>
              </div>
            </div>
          </div>
          <!--end::Item-->
        </div>
        <!--begin::Items-->
      </div>
    </div>
    <!--end::Card-->

    <!--begin::Row-->
    <div class="row">
      <div class="col-lg-12">
        <div class="card card-custom card-stretch gutter-b">
          <!--begin::Header-->
          <div class="card-header border-0 pt-5">
            <h3 class="card-title align-items-start flex-column">
              <span class="card-label font-weight-bolder text-dark">
                Lessons
              </span>
              <span class="text-muted mt-3 font-weight-bold font-size-sm">
                Lesson list of the training.
              </span>
            </h3>
            <div class="card-toolbar">
              <b-button
                v-if="activeTraining.isOnline"
                to="/admin/onlineLessons/create"
                variant="light-info"
              >
                Add Lesson
              </b-button>
              <b-button
                v-else
                to="/admin/offlineLessons/create"
                variant="light-info"
              >
                Add Lesson
              </b-button>
            </div>
          </div>
          <!--end::Header-->
          <!--begin::Body-->
          <div class="card-body pt-3 pb-0">
            <!--begin::Table-->
            <div class="table-responsive">
              <table class="table table-borderless table-vertical-center">
                <thead>
                  <tr>
                    <th class="p-0" style="width: 50px"></th>
                    <th class="p-0" style="min-width: 200px"></th>
                    <th class="p-0" style="min-width: 100px"></th>
                    <th class="p-0" style="min-width: 150px"></th>
                  </tr>
                </thead>
                <tbody>
                  <template v-for="(item, i) in lessons">
                    <tr v-bind:key="i">
                      <td class="pl-0 py-4 font-weight-bolder">{{ i + 1 }}.</td>
                      <td class="pl-0">
                        <a
                          class="
                            text-dark-75 text-hover-primary
                            mb-1
                            font-size-lg
                          "
                        >
                          {{ item.title }}
                        </a>
                      </td>
                      <td class="text-right">
                        <span class="text-dark-75 d-block font-size-lg">
                          {{ item.duration }}
                        </span>
                      </td>
                      <td class="text-right pr-0">
                        <b-button
                          :to="'/admin/offlineLessons/' + item.id + '/update'"
                          class="btn btn-icon btn-light btn-sm mx-3"
                        >
                          <span class="svg-icon svg-icon-md svg-icon-primary">
                            <inline-svg
                              src="/media/svg/icons/Communication/Write.svg"
                            />
                          </span>
                        </b-button>
                        <b-button
                          @click="deleteLesson(item)"
                          class="btn btn-icon btn-light btn-sm"
                        >
                          <span class="svg-icon svg-icon-md svg-icon-primary">
                            <inline-svg
                              src="/media/svg/icons/General/Trash.svg"
                            />
                          </span>
                        </b-button>
                      </td>
                    </tr>
                  </template>
                </tbody>
              </table>
            </div>
            <!--end::Table-->
          </div>
          <!--end::Body-->
          <!--end::Advance Table Widget 2-->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  data() {
    return {
      lessons: []
    };
  },
  created() {
    this.getLessons();
  },
  methods: {
    async getLessons() {
      try {
        const trainingId = this.activeTraining.id;
        const { data } = await this.axios.get(
          `/training/offlineLesson/getAllLessons/${trainingId}`
        );
        this.lessons = data.data;
      } catch (e) {
        console.log(e);
      }
    },
    deleteLesson(lesson) {
      this.confirmDelete();
      console.log(lesson);
    }
  },
  computed: {
    ...mapGetters(['activeTraining'])
  }
};
</script>
