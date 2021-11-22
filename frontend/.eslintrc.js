module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: ["plugin:vue/essential", "@vue/prettier"],
  rules: {
    "no-console": process.env.NODE_ENV === "production" ? "error" : "off",
    "no-debugger": process.env.NODE_ENV === "production" ? "error" : "off",
    "max-len": ["error", { "code": 360 }],
    "prettier/prettier": [
      "warn",
      {
        "singleQuote": true,
        "trailingComma": "none"
      }
    ],
    "vue/no-use-v-if-with-v-for": "off"
  },
  parserOptions: {
    parser: "babel-eslint"
  }
};
