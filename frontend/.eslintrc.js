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
    //"vue/html-closing-bracket-newline": [2, { multiline: "never" }],
    "prettier/prettier": [
      "warn",
      {
        "singleQuote": true,
        "trailingComma": "none",
        "htmlWhitespaceSensitivity": "ignore",
        "arrowParens": "avoid",
        "bracketSameLine": false,
        "bracketSpacing": true,
        "embeddedLanguageFormatting": "auto",
        "insertPragma": false,
        "jsxSingleQuote": false,
        "printWidth": 80,
        "proseWrap": "preserve",
        "quoteProps": "as-needed",
        "requirePragma": false,
        "semi": true,
        "tabWidth": 2,
        "useTabs": false,
        "vueIndentScriptAndStyle": false,
        "jsxBracketSameLine": false
      }
    ],
    "vue/no-use-v-if-with-v-for": "off"
  },
  parserOptions: {
    parser: "babel-eslint"
  }
};
