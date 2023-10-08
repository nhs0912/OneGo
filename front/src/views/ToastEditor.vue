<template >
  <div id="editor"></div>
</template>

<script>
import 'prismjs/themes/prism.css';
import '@toast-ui/editor/dist/toastui-editor.css'; // Editor's Style
import '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight.css';
import Editor from '@toast-ui/editor';
import codeSyntaxHighlight from '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight-all.js';

export default {
  data() {
    return {
      editor: null
    }
  }
  , mounted() {
    this.editor = new Editor({
      usageStatistics: false,
      el: document.querySelector('#editor'),
      height: '500px',
      initialEditType: 'markdown',
      previewStyle: 'vertical',
      plugins: [codeSyntaxHighlight]
    });
  }
}


</script>

