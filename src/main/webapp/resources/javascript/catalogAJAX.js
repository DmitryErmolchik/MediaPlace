var catalogUrl = serverUrl + '/catalog';

function clearCatalog() {
	$('#ajaxCatalogCurrentPath').empty();
	$('#ajaxCatalogDirectories').empty();
	$('#ajaxCatalogFiles').empty();
	$('#ajaxCatalogNavigation').empty();
}

function getCatalog(path) {
	jQuery.getJSON(catalogUrl, {
		path : path
	}).success(function(data) {

		var directories = [];
		var files = [];

		if (data.directories != null) {
			$.each(data.directories, function(index, val) {
				directories.push('<li><a href="javascript:getCatalog(\'' + val.fullPath + '\');">' + val.baseName + '</a></li>');
			});
		}

		if (data.files != null) {
			$.each(data.files, function(index, val) {
				files.push('<li><a href="javascript:playMovie(\'' + val.fullPath + '\')">' + val.baseName + '</a></li>');
			});
		}

		clearCatalog();
		
		$('#ajaxCatalogCurrentPath').append(data.currentPath);
		$('#ajaxCatalogDirectories').append(directories);
		$('#ajaxCatalogFiles').append(files);
		if (path != null && path != '') {
			$('#ajaxCatalogNavigation').append('<a href="javascript:getCatalog(\'' + data.currentPath.substring(0, data.currentPath.lastIndexOf('/')) + '\')">Back</a>');
		}
		if (data.currentPath.lastIndexOf('/') >=0) {
			$('#ajaxCatalogNavigation').append('&nbsp;&nbsp;&nbsp;<a href="javascript:getCatalog()">Home</a>');
		}
	});
}

function playMovie(movie) {
	jQuery.get(serverUrl + 'playMovie', {movie: movie});
}

getCatalog();
