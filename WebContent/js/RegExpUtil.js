var RegExpUtil = (function() {
    function RegExpUtil(){}

    var verificatRet = {
        // 身份证
        identityCard : /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/,
        //identityCard : /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}\d|[X]{1}$/,
        // 手机号
        mobile: /^((1[3|4|5|7|8][0-9]{1})+\d{8})$/,
        // 电子邮箱
        email: /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/,
        // 座机
        phone: /^0\d{2,3}-?\d{7,8}$/,
        // 数字
        number: /^[0-9]*$/,
        // 非零正整数
        NZ_number: /^\+?[1-9][0-9]*$/,
        // 非零负整数
        _NZ_number: /^\-[1-9][0-9]*$/,
        // 非负整数（正整数 + 0）
        _noIntNumber: /^\d+$/,
        // 非正整数（负整数 + 0）
        noIntNumber: /^((-\d+)|(0+))$/,
        // 整数
        intNumber: /^-?\d+$/,
        // 正浮点小数
        doubleNumber: /^(([1-9][0-9]{0,9}[.][0-9]{1,2})|([1-9][0-9]{0,9})|([0][.][0-9]{1}[1-9]{1}))$/,
        // 非正浮点小数（负浮点小数 + 0）
        _noDoubleNum: /^((-\d+(\.\d+)?)|(0+(\.0+)?))$/,
        // 负浮点小数
        _doubleNumber: /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/,
        // 浮点数
        double: /^(-?\d+)(\.\d+)?$/,
        //利率
        lilv: /^(\d|[1-9]\d|100)(\.\d{1,2})?$/,
        //中文、英文、数字但不包括下划线等符号 必填
        str1_20: /^[一-龥A-Za-z0-9]{1,20}$/,
        //中文、英文、数字但不包括下划线等符号 非必填
        str: /^[一-龥A-Za-z0-9]+$/
    };

    /**
     * 检查email格式
     * @param str
     */
    RegExpUtil.prototype.checkEmail=function(str){
        var reg = new RegExp(verificatRet.email); //正则表达式
        return this.RegCheck(str,reg);
    }
    /**
     *检查用户名
     * 只包含中文、英文、下划线
     */
    RegExpUtil.prototype.checkName=function(str){
        var reg = new RegExp("^[一-龥A-Za-z0-9_]+$"); //正则表达式
        return this.RegCheck(str,reg);
    }
    /**
     * 检查密码， 密码(长度在6~30之间，只能包含字母、数字和下划线)：
     */
    RegExpUtil.prototype.checkPsw=function(str){
        var reg = new RegExp("^[A-Za-z0-9_]{6,30}$"); //正则表达式
        return this.RegCheck(str,reg);
    }
    /**
     * 检查金额
     */
    RegExpUtil.prototype.checkPrice=function(str){
        var reg = new RegExp(verificatRet.doubleNumber); //正则表达式
        return this.RegCheck(str,reg);
    }
    /**
     * 检查利率
     */
    RegExpUtil.prototype.checkLilv=function(str){
        var reg = new RegExp(verificatRet.doubleNumber); //正则表达式
        return this.RegCheck(str,reg);
    }
    /**
     * 中文、英文、数字但不包括下划线等符号 必填
     */
    RegExpUtil.prototype.checkStr1_20=function(str){
        var reg = new RegExp(verificatRet.str1_20); //正则表达式
        return this.RegCheck(str,reg);
    }
    /**
     * 中文、英文、数字但不包括下划线等符号 非必填
     */
    RegExpUtil.prototype.checkStr=function(str){
        var reg = new RegExp(verificatRet.str); //正则表达式
        return this.RegCheck(str,reg);
    }


    RegExpUtil.prototype.RegCheck=function(str,reg){
        if(str === ""){ //输入不能为空
            console.log("输入不能为空!");
            return false;
        }else if(!reg.test(str)){ //正则验证不通过，格式不对
            console.log("验证不通过!");
            return false;
        }else{
            console.log("通过！");
            return true;
        }
    }

    return RegExpUtil;
})();