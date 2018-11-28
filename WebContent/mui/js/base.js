
/** 校验两位小数 **/
function checknum(obj)
{
    if(/^\d+\.?\d{0,2}$/.test(obj.value)){
        obj.value = obj.value;
    }else{
        obj.value = obj.value.substring(0,obj.value.length-1);
    }
}



/** input校验 **/
function inputVerify(obj)
{
    var check = true;
    var _obj = $(obj)
    var v = _obj.val();
    var verify = _obj.attr("mui-verify");
    if(verify && verify != null){
        var label = _obj.previousElementSibling;
        var tipText = "";
        if(label && label.innerText != ""){
            tipText = label.innerText;
        }else{
            tipText = _obj.parent().find("label").html();
        }
        var attr = verify.split("|");

        $(attr).each(function(index,element){
            var a = element.split("=");
            var key = a[0];
            var value = a[1];
            if(key == 'required'){
                if(!v || v.trim() == "") {
                    mui.alert(tipText + "不允许为空");
                    check = false;
                    return check;
                }
            }else if(key == 'min'){
                if(Number(value) > Number(v)){
                    mui.alert(tipText + "不能小于" + value);
                    check = false;
                    return check;
                }
            }else if(key == 'max'){
                if(Number(value) < Number(v)){
                    mui.alert(tipText + "不能大于" + value);
                    check = false;
                    return check;
                }
            }else if(key == 'length'){
                if(v.length > parseInt(value)){
                    mui.alert(tipText + "长度不能大于" + value);
                    check = false;
                    return check;
                }
            }else if(key == 'digits'){
                var tel = /^\d+$/;  //正整数
                check = tel.test(v)
                if(!check){
                    mui.alert(tipText + "必须为正整数");
                }
                return check;
            }
        });

    }
    return check;

}