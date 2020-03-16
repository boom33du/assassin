/*
    用户注册页面JS实现
 */

$(function () {
    var userId = getQueryString('userId');
    var registerUserUrl='/user/register';
    var userInfoUrl = "/user/getuserbyid?userId=" + userId;
    var editUserUrl = '/user/modify';
    function getUserInfo(userId){
        if (data.success){
            var userInfo = data.userInfo;
        }
    }


    $('#submit').click(function () {
        /*
        获取列表信息
         */
        var password = $('#user-pass').val();
        var rePassword = $('#user-pass-re').val();

        if (password != rePassword) {
            alert("两次输入的字符串不同");
            return;
        }
        var user = {};
        user.userName = $('#user-name').val();
        user.userPassword = $('#user-pass').val();
        user.gender = $('#gender option:selected').text();
        //储存头像
        var userImg = $('#icon')[0].files[0];
        var formData = new FormData();
        formData.append('userImg',userImg);
        formData.append('userStr',JSON.stringify(user));
        var verifyCodeActual = $('#j_captcha').val();
        if (!verifyCodeActual){
            return;
        }
        formData.append('verifyCodeActual',verifyCodeActual);
        $.ajax({
            url: registerUserUrl,
            type:'POST',
            data:formData,
            contentType:false,
            processData:false,
            cache:false,
            success:function (data) {
                if(data.success()){
                    $.toast('提交成功');
                } else {
                    $.toast('注册失败');
                }
                $('#captcha_img').click();
            }
        })

    })
});