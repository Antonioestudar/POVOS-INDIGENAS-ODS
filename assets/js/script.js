//script.js - Compotamento da página Povos Indígenas e ODS
//Rolagem suave ao clicar nos linkes do menu
const links = document.querySelectorAll('a[href^="#"]');

links.forEach(link => {
    link.addEventListener('click', function(e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});
//Destaque da seção ativa ao rolar
const sections = document.querySelectorAll('main section');
const navItems = document.querySelectorAll('nav a');

window.addEventListener('scroll', () => {
    let current = '';
    sections.forEach(section => {
        const sectionTop = section.offsetTop;
       if (pageYOffset >= sectionTop - 60) {
            current = section.getAttribute('id');
        }
    });

    navItems.forEach(link => {
        link.classList.remove('active');
        if (link.getAttribute('href') === `#${current}`) {
            link.classList.add('active');
        }
    });
});
//script.js - Funcionalidades de acessibilidade

let tamanhoFonte = 100; 

function aumentarFonte() {
    if (tamanhoFonte < 150) {
        tamanhoFonte += 10;
        document.body.style.fontSize = tamanhoFonte + '%';
    }
}

function diminuirFonte() {
    if (tamanhoFonte > 70) {
        tamanhoFonte -= 10;
        document.body.style.fontSize = tamanhoFonte + '%';
    }
}

function alternarContraste() {
    document.body.classList.toggle('contraste');
}
// ---Lógica para o botão de voltar ao topo

const botaoVoltarTopo = document.getElementById('voltar-topo');

window.addEventListener('scroll', () => {


    // Mostrar o botão quando a rolagem for maior que 300 pixels (ajuste conforme necessário)
    if (window.pageYOffset> 300) {
        // exibe o botão
        botaoVoltarTopo.style.opacity = '1';

        botaoVoltarTopo.style.visibility = 'visible';
    } 
    else {
        // esconde o botão
        botaoVoltarTopo.style.opacity = '0';
        botaoVoltarTopo.style.visibility = 'hidden';
    }
       
    
});

