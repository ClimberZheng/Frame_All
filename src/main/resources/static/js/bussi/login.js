function login(){
    var name =$("#username").val();
    var password = $("#pwd").val();

    var requestData= JSON.stringify({
        username:name,
        pwd:password
    });
    var resMessage="fault";

    $.ajax({
        type: "post",
        contentType: "application/json",//指定返回类型
        url: "loginController/login",//请求地址
        data: requestData,
        cache: false,  //禁用缓存
        dataType: "text",//预期返回数据类型
        async: false,
        success: function (responseData) {
            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
            resMessage=responseData;
        },
        error: function () {
           console.log("服务器响应异常");
        }
    });
    var result="pass"==resMessage?true:false;
    if(!result){
        alert("密码输入错误，请重新输入");
        $("#username").val("");
        $("#pwd").val("");

    }

    return result;

}



