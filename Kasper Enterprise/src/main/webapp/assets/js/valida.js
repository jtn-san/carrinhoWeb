/**
 * Validacao de campos obrigatorios
 * @author Jonathan
 */

function validar() {
	//Passo2
	let quantidade = frmProduto.quantidade.value
	//let fone = frmContato.fone.value
	if (quantidade === '') {
		alert('Preencha a quantidade do produto')
		frmProduto.quantidade.focus()
		return false
	} else {
		//a linha abaixo envia os dados do forms para camada controle
	document.forms['frmProduto'].submit()
	}
}

function confirmar(idpro){
	// confirm gera um alerta com uma caixa de opcoes
	let resposta = confirm('Confirma a eclusão deste produto?')
	if (resposta === true) {
		// após confirmado envia ao controller a requisiao delete e o idcon
		window.location.href = 'delete?idpro=' + idpro
	}	
}