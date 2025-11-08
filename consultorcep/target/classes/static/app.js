const API = "http://localhost:8080/api/enderecos";
const resultado = document.getElementById("resultado");

function exibirResultado(data, erro = false) {
  resultado.style.color = erro ? "red" : "#333";
  resultado.textContent = typeof data === "string" ? data : JSON.stringify(data, null, 2);
}

// Buscar por CEP
document.getElementById("buscarCep").addEventListener("click", async () => {
  const cep = document.getElementById("cep").value.trim();
  if (!cep) return exibirResultado("Informe um CEP.", true);

  try {
    const res = await fetch(`${API}/cep/${cep}`);
    if (!res.ok) throw new Error("CEP não encontrado.");
    const data = await res.json();
    exibirResultado(data);
  } catch (e) {
    exibirResultado(e.message, true);
  }
});

// Buscar por Logradouro
document.getElementById("buscarLogradouro").addEventListener("click", async () => {
  const logradouro = document.getElementById("logradouro").value.trim();
  if (!logradouro) return exibirResultado("Informe um logradouro.", true);

  try {
    const res = await fetch(`${API}/logradouro/${logradouro}`);
    if (!res.ok) throw new Error("Nenhum endereço encontrado.");
    const data = await res.json();
    exibirResultado(data);
  } catch (e) {
    exibirResultado(e.message, true);
  }
});

// Buscar por Cidade
document.getElementById("buscarCidade").addEventListener("click", async () => {
  const cidade = document.getElementById("cidade").value.trim();
  if (!cidade) return exibirResultado("Informe uma cidade.", true);

  try {
    const res = await fetch(`${API}/cidade/${cidade}`);
    if (!res.ok) throw new Error("Nenhum endereço encontrado.");
    const data = await res.json();
    exibirResultado(data);
  } catch (e) {
    exibirResultado(e.message, true);
  }
});

// Cadastrar Novo Endereço
document.getElementById("adicionarCep").addEventListener("click", async () => {
  const cep = document.getElementById("novoCep").value.trim();
  const logradouro = document.getElementById("novoLogradouro").value.trim();
  const bairro = document.getElementById("novoBairro").value.trim();
  const cidade = document.getElementById("novaCidade").value.trim();
  const estado = document.getElementById("novoEstado").value.trim();

  if (!cep || !logradouro || !bairro || !cidade || !estado)
    return exibirResultado("Preencha todos os campos.", true);

  try {
    const res = await fetch(API, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ cep, logradouro, bairro, cidade, estado }),
    });

    if (!res.ok) throw new Error("Erro ao cadastrar endereço.");
    exibirResultado(`Endereço com CEP ${cep} cadastrado com sucesso!`);
  } catch (e) {
    exibirResultado(e.message, true);
  }
});
