package cn.stylefeng.1466951331.modular.user.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.1466951331.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.1466951331.modular.system.model.Info;
import cn.stylefeng.1466951331.modular.user.service.IInfoService;

/**
 * 病人控制�?
 *
 * @author fengshuonan
 * @Date 2018-12-29 14:09:37
 */
@Controller
@RequestMapping("/info")
public class InfoController extends BaseController {

    private String PREFIX = "/user/info/";

    @Autowired
    private IInfoService infoService;

    /**
     * 跳转到病人首�?
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "info.html";
    }

    /**
     * 跳转到添加病�?
     */
    @RequestMapping("/info_add")
    public String infoAdd() {
        return PREFIX + "info_add.html";
    }

    /**
     * 跳转到修改病�?
     */
    @RequestMapping("/info_update/{infoId}")
    public String infoUpdate(@PathVariable Integer infoId, Model model) {
        Info info = infoService.selectById(infoId);
        model.addAttribute("item",info);
        LogObjectHolder.me().set(info);
        return PREFIX + "info_edit.html";
    }

    /**
     * 获取病人列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return infoService.selectList(null);
    }

    /**
     * 新增病人
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Info info) {
        infoService.insert(info);
        return SUCCESS_TIP;
    }

    /**
     * 删除病人
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer infoId) {
        infoService.deleteById(infoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改病人
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Info info) {
        infoService.updateById(info);
        return SUCCESS_TIP;
    }

    /**
     * 病人详情
     */
    @RequestMapping(value = "/detail/{infoId}")
    @ResponseBody
    public Object detail(@PathVariable("infoId") Integer infoId) {
        return infoService.selectById(infoId);
    }
}
