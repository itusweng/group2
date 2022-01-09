<template>
  <div class="topbar-item mr-5">
    <div id="kt_quick_notifications_toggle">
      <div class="btn btn-icon btn-sm btn-primary font-weight-bolder p-0">
        {{ unreadCount }}
      </div>
    </div>

    <!-- begin::Notifications Panel-->
    <div
      id="kt_quick_notifications"
      ref="kt_quick_notifications"
      class="offcanvas offcanvas-right p-10"
    >
      <div
        class="
          offcanvas-header
          d-flex
          align-items-center
          justify-content-between
          mb-10
        "
      >
        <h3 class="font-weight-bold m-0">
          Notifications
          <small class="text-muted font-size-sm ml-2">
            {{ unreadCount }} New
          </small>
        </h3>
        <button
          @click="fetchData"
          class="btn btn-xs btn-icon btn-light btn-hover-primary"
        >
          <i class="ki ki-refresh icon-xs text-muted"></i>
        </button>
      </div>
      <!--begin::Content-->
      <div class="offcanvas-content pr-5 mr-n5">
        <div class="navi navi-icon-circle navi-spacer-x-0">
          <template v-for="(item, i) in list">
            <!--begin::Item-->
            <a href="#" @click="markAsRead(item)" class="navi-item" :key="i">
              <div class="navi-link rounded">
                <div class="symbol symbol-50 mr-3">
                  <div class="symbol-label">
                    <i class="icon-lg flaticon-bell text-success" />
                  </div>
                </div>
                <div class="navi-text">
                  <div class="font-weight-bold font-size-lg" v-if="!item.read">
                    {{ item.message }}
                  </div>
                  <div class="text-muted" v-else>
                    {{ item.message }}
                  </div>
                </div>
              </div>
            </a>
            <!--end::Item-->
          </template>
        </div>
        <div class="text-center pt-5" v-if="list.length < total">
          <b-button @click="loadMore" variant="light-primary">
            Load More
          </b-button>
        </div>
      </div>
      <!--end::Content-->
    </div>
    <!-- end::Notifications Panel-->
  </div>
</template>

<script>
import KTLayoutQuickNotifications from '@/assets/js/layout/extended/quick-notifications.js';

export default {
  name: 'KTQuickPanel',
  data() {
    return {
      list: [],
      total: 0,
      unreadCount: 0,
      page: 0
    };
  },
  created() {
    this.fetchData();
  },
  mounted() {
    // Init Quick Offcanvas Panel
    KTLayoutQuickNotifications.init(this.$refs['kt_quick_notifications']);
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
            page: this.page,
            size: 10
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
    async markAsRead(notification) {
      try {
        await this.axios.post('/notification/user/notificationsHaveRead', {
          notificationIds: [notification.id]
        });

        notification.read = true;
        this.unreadCount--;
      } catch (e) {
        console.log(e);
      }
    },
    loadMore() {
      this.page++;

      this.getNotifications();
    }
  }
};
</script>
