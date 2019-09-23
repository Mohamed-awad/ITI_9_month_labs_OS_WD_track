function count_letter(st, ch){
    var x = 0 ;
    for(var i=0; i < st.length; i++)
    {
        if(st[i] === ch)
        {
            x++;
        }
    }
    console.log(ch + " ---> " + x);
}

function fizz_buzz(x){
    if(x%3 == 0 && x%5 == 0)
    {
        console.log("fizz buzz");
    }
    else if(x%3 == 0)
    {
        console.log("fizz");
    }
    else if(x%5 == 0)
    {
        console.log("buzz");
    }
    else
    {
        console.log("none");
    }
}

function bottle(st){
    var l = st.length;
    var x = Math.floor(Math.random() * Math.floor(l));
    var y = Math.floor(Math.random() * Math.floor(l));
    while(y == x)
    {
        var y = Math.floor(Math.random() * Math.floor(l));
    }
    console.log(st[x]);
    console.log(st[y]);
}

function char_game(st, ch){
    var x = [] ;
    for(var i=0; i < st.length; i++)
    {
        if(st[i] === ch)
        {
            x.push(i);
        }
    }
    console.log(x);
}

function greedy(x){
    x = parseInt(x * 100);
    console.log(parseInt(x/100) + " dollars");
    x %= 100;
    console.log(parseInt(x/25) + " quarter");
    x = x % 25;  
    console.log(parseInt(x/10) + " dime");
    x = x % 5;
    console.log(parseInt(x) + " cent");
}

function mario(x){
    for (var i = 0; i < x; i++) {
        st = "";
        for(var j = x-i-1 ; j > 0; j--)
            st += ' ';
        for(var j = 0; j <= i; j++)
            st += '*';
        console.log(st);
    }
}

function what_am_i(){
    x = confirm("Do you fly?");
    if(x) {
        x = confirm("Are you Wild?");
        if(x){
            console.log("Eagle");
        }
        else{
            console.log("Parrot");
        }
    }
    else {
        x = confirm("Do you live under sea?");
        if(x){
            x = confirm("Are You evil?");
            if(x){
                console.log("Shark");
            }
            else{
                console.log("Dolphin");
            }
        }
        else{
            x = confirm("Are You Wild?");
            if(x){
                console.log("Lion");
            }
            else{
                console.log("Cat");
            }
        }
    }
}