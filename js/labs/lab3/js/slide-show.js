var im = document.getElementsByTagName('img');
var x = 0;
var imgs = [
    'img/gray.png',
    'img/Lemon-juice.png',
    'img/orange.png',
    'img/green.png',
    'img/orange-juice.png',
    'img/red.png',
];
var inter = null;

var next_play = function() {
    x++;
    x = x % 6;
    im[0].src = imgs[x];
}

var play = function() {
    if(inter != null)
    {
        clearInterval(inter);
    }
    inter = setInterval(next_play ,1000);
}

var stop = function() {
    if(inter != null)
    {
        clearInterval(inter);
    }
}

var next = function() {
    if(inter != null)
    {   
        clearInterval(inter);
    }
    x++;
    x = x % 6;
    im[0].src = imgs[x];
}

var previous = function() {
    if(inter != null)
    {
        clearInterval(inter);
    }
    x--;
    x = (x % 6 + 6) % 6;
    im[0].src = imgs[x];
    
}

function main() {
    var btns = document.getElementsByTagName('button');
    btns[0].addEventListener('click', previous);
    btns[1].addEventListener('click', play);
    btns[2].addEventListener('click', stop);
    btns[3].addEventListener('click', next); 
}

main();
