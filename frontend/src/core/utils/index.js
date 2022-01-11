import moment from 'moment';

export const formatDate = (date, mode = 1) => {
  switch (mode) {
    case 1:
      return moment(date).format('DD/MM/YYYY');
    case 2:
      return moment(date).format('D MMMM YYYY');
    case 3:
      return moment(date).format('D/M/YY HH:mm');
    case 4:
      return moment(date).format('D MMMM YYYY HH:mm');
  }
};
