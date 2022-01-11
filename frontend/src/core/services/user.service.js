const ID_KEY = 'tp_user';

export const getUser = () => {
  return JSON.parse(window.localStorage.getItem(ID_KEY));
};

export const saveUser = (user) => {
  console.log(user);
  window.localStorage.setItem(ID_KEY, JSON.stringify(user));
};

export const destroyUser = () => {
  window.localStorage.removeItem(ID_KEY);
};

export default { getUser, saveUser, destroyUser };
