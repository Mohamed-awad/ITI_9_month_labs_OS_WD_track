function make_me_live()
{
    var pl = document.getElementsByTagName('p');
    for(var i = 0; i < pl.length; i++)
    {
        var ll = pl[i].textContent;
        pl[i].innerHTML = '<a '+'href="https://'+ll + '">' + ll.substr(4, ll.length - 8) + '</a>'  
    }
}