var x = -1;
function fire(){
    x++;
    x = x % 3;
    on(x);
}

function on(x){
    var im = document.images;
    var m_p = document.getElementsByTagName('p');
    if(x == 0)
    {
        im[0].src = 'img/red.png';
        im[1].src = 'img/gray.png';
        im[2].src = 'img/gray.png';
        m_p[0].textContent = 'ready';
    }
    else if(x == 1)
    {
        im[0].src = 'img/gray.png';
        im[1].src = 'img/orange.png';
        im[2].src = 'img/gray.png';
        m_p[0].textContent = 'steady';
    }
    else if(x == 2)
    {
        im[0].src = 'img/gray.png';
        im[1].src = 'img/gray.png';
        im[2].src = 'img/green.png';
        m_p[0].textContent = 'Go';
    }
    else
    {
        im[0].src = 'img/gray.png';
        im[1].src = 'img/gray.png';
        im[2].src = 'img/gray.png';
        m_p[0].textContent = '';
    }
}

function go(){
    setInterval(fire, 500);
}

go();
