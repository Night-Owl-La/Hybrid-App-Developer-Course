<!-- CKEditor Guide : https://ckeditor.com/docs/index.html -->

<script src="https://cdn.ckeditor.com/4.13.1/full/ckeditor.js"></script>

---------------------------------------------------------------------------------------

<script>
	CKEDITOR.replace('?textarea_id||name?', {uiColor: '#CCEAEE'});
</script>

----------------------------------------------------------------------------------------
<script>
	// Replace the <textarea id="editor1"> with a CKEditor instance, using default configuration.
	CKEDITOR.replace('p_content', {
		filebrowserUploadUrl: '${pageContext.request.contextPath}/ckeditorImageUpload.do',
		enterMode: CKEDITOR.ENTER_BR,
		shiftEnterMode: CKEDITOR.ENTER_P,
		toolbarGroups: [
			/*
				{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
				{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
				{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ] },
				{ name: 'forms' },
				'/',*/

			{	name: 'document', groups: ['mode', 'document', 'doctools'] },
			{ name: 'basicstyles', groups: ['basicstyles', 'cleanup'] },
			{ name: 'paragraph', groups: ['list', 'indent', 'blocks', 'align', 'bidi'] },
			{ name: 'links' },
			{ name: 'insert' },
			'/',
			{ name: 'styles' },
			{ name: 'colors' },
			{ name: 'tools' },
			{ name: 'others' },
			{ name: 'about' }
		]
	});

	//이미지 업로드
	CKEDITOR.on('dialogDefinition', function (ev) {
		var dialogName = ev.data.name;
		var dialogDefinition = ev.data.definition;

		switch (dialogName) {
			case 'image': //Image Properties dialog
				//dialogDefinition.removeContents('info');
				dialogDefinition.removeContents('Link');
				dialogDefinition.removeContents('advanced');
				break;
		}
	});
</script>
