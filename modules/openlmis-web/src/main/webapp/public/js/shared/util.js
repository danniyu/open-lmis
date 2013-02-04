var utils = {
  getFormattedDate:function (date) {
    return ('0' + date.getDate()).slice(-2) + '/'
        + ('0' + (date.getMonth() + 1)).slice(-2) + '/'
        + date.getFullYear();
  },

  isNumber:function (number) {
    return !isNaN(utils.parseIntWithBaseTen(number));
  },

  parseIntWithBaseTen:function (number) {
    return parseInt(number, 10);
  },

  getValueFor:function (number) {
    return utils.isNumber(number) ? utils.parseIntWithBaseTen(number) : null;
  }
};