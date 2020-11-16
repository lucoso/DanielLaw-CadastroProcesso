$(document).ready(function() {
	$('#buscarprocesso').click(
			function(event) {
				var numeroProcesso = $('#numeroprocesso').val();
				console.log("entrou");
				console.log(numeroProcesso);
				$.ajax({
					type: "GET",
					url : 'https://patentscope.wipo.int/search/pt/detail.jsf?docId='+numeroProcesso+'&redirectedID=true', 
					dataType: "html",
					success : function(data, status) {
						$("#numeropub").attr("detailMainForm:pctBiblio:detailPCTtableWO");
						$("#numeroint").attr("detailMainForm:pctBiblio:j_idt1199")
						$("#data").attr("detailMainForm:pctBiblio:detailPCTtablePubDate")
						$("#requerentes").attr("detailMainForm:pctBiblio:j_idt1501")
						$("#titulo").attr("detailMainForm:pctBiblio:j_idt1827")
					}
				});
			});
});





