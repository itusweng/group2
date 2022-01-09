<template>
  <!--begin::Advance Table Widget 10-->
  <div class="card card-custom gutter-b">
    <!--begin::Header-->
    <div class="card-header border-0 py-5">
      <h3 class="card-title align-items-start flex-column">
        <span class="card-label font-weight-bolder text-dark">
          Notifications
        </span>
      </h3>
      <div class="card-toolbar" v-if="selectedList.length > 0">
        <button
          @click="markAsRead"
          class="btn btn-light-info font-weight-bolder font-size-sm"
        >
          Mark as Read
        </button>
      </div>
    </div>
    <!--end::Header-->
    <!--begin::Body-->
    <div class="card-body py-0">
      <!--begin::Table-->
      <div class="table-responsive">
        <table
          class="table table-head-custom table-vertical-center"
          id="kt_advance_table_widget_4"
        >
          <thead>
            <tr class="text-left">
              <th class="pl-0" style="width: 30px">
                <label class="checkbox checkbox-lg checkbox-single mr-2">
                  <input
                    type="checkbox"
                    v-model="allSelected"
                    @input="checkAll"
                  />
                  <span></span>
                </label>
              </th>
              <th class="pl-0" style="min-width: 120px">Message</th>
              <th style="min-width: 110px">Type</th>
              <th style="min-width: 110px">Date</th>
            </tr>
          </thead>
          <tbody>
            <template v-for="(item, i) in list">
              <tr :key="i">
                <td class="pl-0 py-6">
                  <label class="checkbox checkbox-lg checkbox-single">
                    <input
                      type="checkbox"
                      :value="item.id"
                      :checked="selectedList.includes(item.id)"
                      @change="itemChecked"
                    />
                    <span></span>
                  </label>
                </td>
                <td class="pl-0">
                  <a
                    href="#"
                    class="text-dark-75 text-hover-primary font-size-lg"
                    :class="{
                      'text-muted': item.read,
                      'font-weight-bolder': !item.read
                    }"
                  >
                    {{ item.message }}
                  </a>
                </td>
                <td>
                  <span class="d-block font-size-lg">
                    {{
                      item.type === 'enrolled_training_notification' &&
                      'Registration'
                    }}
                  </span>
                </td>
                <td>
                  <span class="d-block font-size-lg">
                    {{ item.createdDate | formatDate(3) }}
                  </span>
                </td>
              </tr>
            </template>
          </tbody>
        </table>
        <pagination
          :total-rows="total"
          :per-page.sync="pagination.size"
          :current-page.sync="pagination.page"
        />
      </div>
      <!--end::Table-->
    </div>
    <!--end::Body-->
  </div>
  <!--end::Advance Table Widget 10-->
</template>

<script>
export default {
  data() {
    return {
      allSelected: false,
      list: [],
      selectedList: [],
      total: 0,
      pagination: {
        page: 1,
        size: 5
      },
      unreadCount: 0
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.page = 0;
      this.getNotifications();
      this.getUnreadNotifications();
    },
    async getNotifications() {
      try {
        this.loading = true;
        const { data } = await this.axios.post(
          '/notification/user/getAllByUserId',
          {
            userId: this.$store.getters.currentUser.id,
            page: this.pagination.page - 1,
            size: this.pagination.size
          }
        );
        if (this.page === 0) {
          this.list = data.data.notifications;
          this.total = data.data.total;
        } else {
          this.list = [...this.list, ...data.data.notifications];
        }
      } catch (e) {
        console.log(e);
      } finally {
        this.loading = false;
      }
    },
    async getUnreadNotifications() {
      try {
        this.loading = true;
        const { data } = await this.axios.post(
          '/notification/user/getAllUnreadByUserId',
          {
            userId: this.$store.getters.currentUser.id,
            page: 0,
            size: 10
          }
        );
        this.unreadCount = data.data.total;
      } catch (e) {
        console.log(e);
      } finally {
        this.loading = false;
      }
    },
    async markAsRead() {
      try {
        await this.axios.post('/notification/user/notificationsHaveRead', {
          notificationIds: this.selectedList
        });

        this.selectedList = [];
        this.allSelected = false;

        this.fetchData();
      } catch (e) {
        console.log(e);
      }
    },
    checkAll(event) {
      if (event.target.checked) {
        this.selectedList = this.list.map(item => item.id);
      } else {
        this.selectedList = [];
      }

      console.log(this.selectedList);
    },
    itemChecked(item) {
      if (item.target.checked) {
        this.selectedList.push(+item.target.value);
      } else {
        this.selectedList = this.selectedList.filter(
          i => i !== +item.target.value
        );
      }
      console.log(this.selectedList);
    }
  },
  watch: {
    pagination: {
      handler: 'getNotifications',
      deep: true
    }
  }
};
</script>
