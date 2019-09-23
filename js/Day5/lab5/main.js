let x = document.getElementsByTagName('div')[0];
let inter;
const move_right = () => {
    let y = x.style.left;
    let yy = 0;
    if(y !== "")
        yy = parseInt(y);
    let z = yy + 10;
    if(z > document.body.offsetWidth - 90)
    {
        clearInterval(inter);
        inter = setInterval(move_down, 50);
    }
    x.style.left = z+'px';
};

const move_down = () => {
    let y = x.style.top;
    let yy = 0;
    if(y !== "")
        yy = parseInt(y);
    let z = yy + 10;
    if(z > document.body.offsetHeight - 90)
    {
        clearInterval(inter);
        inter = setInterval(move_left, 50);
    }
    x.style.top = z+'px';
};

const move_left = () => {
    let y = x.style.left;
    let yy = 0;
    if(y !== "")
        yy = parseInt(y);
    let z = yy - 10;
    if(z < 15)
    {
        clearInterval(inter);
        inter = setInterval(move_up, 50);
    }
    x.style.left = z+'px';
};

const move_up = () => {
    let y = x.style.top;
    let yy = 0;
    if(y !== "")
        yy = parseInt(y);
    let z = yy - 10;
    if(z < 15)
    {
        clearInterval(inter);
        inter = setInterval(move_right, 50);
    }
    x.style.top = z+'px';
};


inter = setInterval(move_right, 50);
