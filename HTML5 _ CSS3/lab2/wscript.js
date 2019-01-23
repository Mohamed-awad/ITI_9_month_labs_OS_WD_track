

onmessage = function(e) {
    let msg = e.data.value;
    postMessage({value : msg.toUpperCase()});
}