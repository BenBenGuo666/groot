/*function upload_picture() {
    var form = document.getElementById('upload'),
        formData = new FormData(form);
    $.ajax({
        url: "https://127.0.0.1/demo/uploadPic",
        type: "post",
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            if (res) {
                alert("上传成功！");
            }
            console.log(res);
            $("#pic").val("");
            $(".showUrl").html(res);
            $(".showPic").attr("src", res);
        },
        error: function (err) {
            alert("网络连接失败,稍后重试", err);
        }
    })
};*/

document.getElementById('upload').addEventListener('change', function (event) {
    var $file = event.currentTarget;
    var formData = new FormData();
    var file = $file.files;
    formData = new FormData();
    formData.append("pic", file[0]);
    $.ajax({
        url: "/demo/demo/uploadPic",
        type: 'POST',
        dataType: 'json',
        data: formData,
        contentType: false,
        processData: false
    })
        .done(data => {
            $('#box').append(`<div class="photo-item">
            <img class="item-image" width="100%" height="100%" src="${data.url}"/>
        </div>`);
        })
        .fail(data => {
            console.log(data);
        });
});