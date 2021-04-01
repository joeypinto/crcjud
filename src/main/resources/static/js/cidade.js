function exibirMensagem() {
	select_box = document.getElementById("comboCidade");
	select_box.options.length = 0;
}
function getComboA(cidade) {
	var data = cidade;
	console.log(data);
	exibirMensagem()
	fetch('http://localhost:8080/cidades?id=' + data.value)
		.then(response => response.json())
		.then(json => {
			valuedd = json
			console.log(valuedd);
			valuedd.forEach((language) => {
				option = new Option(language.nome_municipio, language.id);
				console.log(option);
				comboCidade.options[comboCidade.options.length] = option;
				document.getElementById("comboCidade").disabled = false;
			});

		}
		)



}