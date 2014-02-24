var remoteUrl = serverUrl + '/remote';

function clearCatalog() {
	$('#ajaxCatalogCurrentPath').empty();
	$('#ajaxCatalogDirectories').empty();
	$('#ajaxCatalogFiles').empty();
	$('#ajaxCatalogNavigation').empty();
}

function loadRemoteCommands() {
	jQuery.getJSON(remoteUrl).success(function(data) {
		var commands = [];
		
		$.each(data, function(index, value) {
			commands.push('<li><a href="javascript:fireCommand(\'' + value.name + '\')">' + index + '</a></li>')
		})
		
		$('#ajaxPlayerControl').append(commands);
	})
}

function fireCommand(command) {
	jQuery.get(remoteUrl, {command: command});
}

loadRemoteCommands();