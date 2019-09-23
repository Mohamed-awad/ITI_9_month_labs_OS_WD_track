function find_my_family(st)
{
    var ee = document.getElementsByTagName(st);
    var x = [];
    for(var i = 0 ; i < ee.length; i++)
    {
        var xx = {};
        xx.parent = ee[i].parentElement.nodeName;
        xx.children = ee[i].children;
        xx.siblings = ee[i].siblings;
        x.push(xx);
    }
    console.log(x);
}