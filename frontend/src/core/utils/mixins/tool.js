import { formatDate } from '@/core/utils';
import Swal from 'sweetalert2';

export const toolMixin = {
  filters: {
    formatDate
  },
  methods: {
    confirmDelete() {
      return Swal.fire({
        title: '',
        text: this.$t('notification.swal.confirmDelete'),
        icon: 'error',
        confirmButtonColor: 'red',
        confirmButtonText: this.$t('common.delete'),
        cancelButtonText: this.$t('common.cancel'),
        showCancelButton: true,
        reverseButtons: true,
        heightAuto: false
      });
    },
    confirmChanges() {
      return Swal.fire({
        icon: 'warning',
        title: this.$t('notification.swal.saveChanges'),
        showCancelButton: true,
        reverseButtons: true,
        confirmButtonText: this.$t('common.save'),
        cancelButtonText: this.$t('common.dontSave')
      });
    },
    toast({ type, title, message, item, data }) {
      if (!type) type = 'success';
      if (!title) {
        if (type === 'success') title = 'success';
        else title = 'error';
      }

      const text = this.$t('notification.messages.' + message, {
        item: this.$t('notification.items.' + (item ? item : 'item')),
        ...data
      });

      this.$bvToast.toast(text, {
        title: this.$t('notification.messages.' + title),
        variant: type,
        solid: true,
        toaster: 'b-toaster-top-right',
        appendToast: true
      });
    }
  }
};
