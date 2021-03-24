function exibirMensagem()
{
select_box = document.getElementById("comboCidade");
select_box.options.length=0;
}
function getComboA() {
exibirMensagem()
fetch('http://localhost:8080/enderecos/rio')
  .then(response => response.json())
  .then(json => {
   valuedd = json
   console.log(valuedd);
valuedd.forEach((language) => {
   option = new Option(language.nome_uf);
   console.log(option); 		
  comboCidade.options[comboCidade.options.length] = option;
});

  }
  )
  .then(json => console.log(json))

 
}