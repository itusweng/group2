FormData.prototype.clear = function () {
  var k = [];
  for (var key of this.keys()) {
    k.push(key);
  }
  k.map(key => this.delete(key));
};

FormData.prototype.json = function (form) {
  if (this.has('form')) {
    this.set('form', JSON.stringify(form));
  } else {
    this.append('form', JSON.stringify(form));
  }
};

FormData.prototype.build = function (data, parentKey) {
  if (
    data &&
    typeof data === 'object' &&
    !(data instanceof Date) &&
    !(data instanceof File)
  ) {
    Object.keys(data).forEach(key => {
      this.build(data[key], parentKey ? `${parentKey}[${key}]` : key);
    });
  } else {
    const value = data == null ? '' : data;

    if (this.has(parentKey)) {
      this.set(parentKey, value);
    } else {
      this.append(parentKey, value);
    }
  }

  return this;
};
