package cn.stylefeng.1466951331.modular.medicinemanager.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.1466951331.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.1466951331.modular.system.model.MedicineInfo;
import cn.stylefeng.1466951331.modular.medicinemanager.service.IMedicineInfoService;

/**
 * 药物管理控制�?
 *
 * @author fengshuonan
 * @Date 2018-12-29 16:22:31
 */
@Controller
@RequestMapping("/medicineInfo")
public class MedicineInfoController extends BaseController {

    private String PREFIX = "/medicinemanager/medicineInfo/";

    @Autowired
    private IMedicineInfoService medicineInfoService;

    /**
     * 跳转到药物管理首�?
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "medicineInfo.html";
    }

    /**
     * 跳转到添加药物管�?
     */
    @RequestMapping("/medicineInfo_add")
    public String medicineInfoAdd() {
        return PREFIX + "medicineInfo_add.html";
    }

    /**
     * 跳转到修改药物管�?
     */
    @RequestMapping("/medicineInfo_update/{medicineInfoId}")
    public String medicineInfoUpdate(@PathVariable Integer medicineInfoId, Model model) {
        MedicineInfo medicineInfo = medicineInfoService.selectById(medicineInfoId);
        model.addAttribute("item",medicineInfo);
        LogObjectHolder.me().set(medicineInfo);
        return PREFIX + "medicineInfo_edit.html";
    }

    /**
     * 获取药物管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return medicineInfoService.selectList(null);
    }

    /**
     * 新增药物管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(MedicineInfo medicineInfo) {
        medicineInfoService.insert(medicineInfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除药物管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer medicineInfoId) {
        medicineInfoService.deleteById(medicineInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改药物管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(MedicineInfo medicineInfo) {
        medicineInfoService.updateById(medicineInfo);
        return SUCCESS_TIP;
    }

    /**
     * 药物管理详情
     */
    @RequestMapping(value = "/detail/{medicineInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("medicineInfoId") Integer medicineInfoId) {
        return medicineInfoService.selectById(medicineInfoId);
    }
}
