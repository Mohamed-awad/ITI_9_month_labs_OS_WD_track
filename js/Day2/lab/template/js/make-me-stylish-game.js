function make_me_stylish(tt, ob)
{
    var tt1 = document.getElementsByTagName(tt);
    for(var i = 0 ; i < tt1.length; i++)
    {
        for(var x in ob)
        {
            tt1[i].style[x] = ob[x];
        }
    }
}