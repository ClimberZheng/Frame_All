$(function () {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/LFitness/commodity/getAll",
        dataType: "JSON",
        async: true,
        success: function (map) {
            console.log(map);
            var user=map.loginuser;
            console.log(user);
            exchangeHeader(user);
            var list=map.commitys;
            console.log(list);
            fillData(list);
        },
        error: function (res) {
            alert("数据初始化失败！");
        }


    });

    function fillData(list) {
        console.log("data to show page");
        //轮播
        var contentCode1 = createBox(list, 1);
        var contentCode2 = createBox(list, 2);
        var content = contentCode1 + contentCode2;
        $("#carsou_va").html(content);

        //时节热销
        var contentHot1 = createhot(list, 1);
        $("#hot1").html(contentHot1);

        //最优佳品
        var contentHot2 = createhot(list, 2);
        $("#hot2").html(contentHot2);

        //更多推荐
        var contentMore = createMoreSugg(list);
        $("#moreSuggest").html(contentMore);


    }

    function createBox(list, part) {
        var baseCode = "<div class=\"item-box\">\n";
        var i = (part - 1) * 4;
        if ((4 * part)<list.length-1){

            for (i; i < 4 * part; i++) {
                baseCode = baseCode +
                    "<div class=\"item\">\n" +
                    "       <a id='commodity" + list[i].comid + "' href=\"details/"+list[i].comid+"\"><img style=\"width: 190px; height: 190px;\" src=\"" + list[i].pic + "\"></a>\n" +
                    "       <div class=\"title\">" + list[i].cName + "</div>\n" +
                    "             <div class=\"price\">\n" +
                    "               <span>￥" + list[i].price + "</span>\n" +
                    "               <del>￥" + (list[i].price + 30) + "</del>\n" +
                    "             </div>\n" +
                    "</div>\n";
            }
        }
        return baseCode + "</div>";
    }

    function createhot(list, index) {
        var iniValue = 8 + (index - 1) * 5;
        var content = "";
        if (iniValue<list.length-1){

            for (var i=iniValue; i < iniValue + 5; i++) {
                content += "<a id='commodity" + list[i].comid + "' href=\"details/"+list[i].comid+"\"><img style=\"width: 190px; height: 199px;\" src=\"" + list[i].pic + "\"></a>"
                // console.log(list[i].comid);
            }
        }
        return content;
    }
    //
    function createMoreSugg(list) {
        var content = "";
        if (19<list.length-1){

            for (var i = 19; i < list.length; i++) {
                content += "<div class=\"list-item\">\n" +
                    "            <a  id='commodity" + list[i].comid + "'  href=\"details/"+list[i].comid+"\">" +
                    "<img style=\"width: 220px; height: 270px;\" src=\"" + list[i].pic + "\">\n" +
                    "            <p>" + list[i].description + "</p>\n" +
                    "            <span>￥" + (list[i].price) + "</span>\n" +
                    "          </div>"
            }
        }
        return content;
    }

    function exchangeHeader(user) {
        var content="";
        if(user!=null){
            if(user.statue=="M") {
                content = "<div class=\"login\"><a href=\"/LFitness/manage\">平台信息管理</a></div>\n";
            }else {
                content = "<div class=\"login\"><a href=\"/LFitness/personalMes\">个人信息管理</a></div>\n";
            }
            content+= "        <div class=\"login\"><a href=\"/LFitness/logout\">注销</a></div>"
        }else {
            content = "<div class=\"login\"><a href=\"/LFitness/\">登录</a></div>\n" +
                "        <div class=\"login\"><a href=\"/LFitness/regist\">注册</a></div>"
        }
        $(".headerFlag").html(content)

    }


});