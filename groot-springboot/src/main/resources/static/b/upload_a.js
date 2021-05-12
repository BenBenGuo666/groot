//首先监听input框的变动，选中一个新的文件会触发change事件
document.querySelector("#file").addEventListener("change",function () {
    //获取到选中的文件
    var file = document.querySelector("#file").files[0];
    //创建formdata对象
    var formdata = new FormData();
    formdata.append("file",file);
    //创建xhr，使用ajax进行文件上传
    var xhr = new XMLHttpRequest();
    xhr.open("post","/view/goUpload");
    //回调
    xhr.onreadystatechange = function () {
        if (xhr.readyState==4 && xhr.status==200){
            document.querySelector("#callback").innerText = xhr.responseText;
        }
    }
    //获取上传的进度
    xhr.upload.onprogress = function (event) {
        if(event.lengthComputable){
            var percent = event.loaded/event.total *100;
            document.querySelector("#progress .progress-item").style.width = percent+"%";
        }
    }
    //将formdata上传
    xhr.send(formdata);
});