function count_me(tt, ob)
{
    var tt1 = document.getElementsByTagName(tt);
    var tt2 = document.getElementsByClassName(ob.Class);
    var tt3 = document.getElementById(ob.Id);
    var tt4 = document.getElementsByName(ob.Name);
    var st = '';
    st += 'all: ' + tt1.length + ', ';
    st += 'Class: ' + tt2.length + ', ';
    if(tt3 != null)
    {
        st += 'Id: True'+ ', ';
    }
    else
    {
        st += 'Id: False'+ ', ';
    }
    st += 'Name: ' + tt4.length;
    console.log(st);
}