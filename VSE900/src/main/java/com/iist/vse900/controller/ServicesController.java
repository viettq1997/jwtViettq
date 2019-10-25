package com.iist.vse900.controller;

import com.iist.vse900.controller.base.BaseController;
import com.iist.vse900.domain.dto.ServiceDTO;
import com.iist.vse900.domain.dto.param.UpdateServiceClickParamDTO;
import com.iist.vse900.domain.model.UserServices;
import com.iist.vse900.service.ServicesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(description = "Controller thao tác với Service")
@RequestMapping(value = "/service")
public class ServicesController extends BaseController {

    @Autowired
    ServicesService servicesService;

    @CrossOrigin
    @ApiOperation("Lấy ra danh sách tất cả Service (sắp xếp giảm dần theo số lần click)")
    @GetMapping(value = "/list")
    public ResponseEntity list(@RequestParam @ApiParam("userId của người dùng hiện tại") Long userId) {
        List<ServiceDTO> listService = servicesService.getListService(userId);
        return buildResultJson(200, "", listService);
    }

    @CrossOrigin
    @ApiOperation("Tăng sô lượng click Service")
    @PostMapping(value = "/add-click-to-service")
    public ResponseEntity addServiceClick(@RequestBody UpdateServiceClickParamDTO updateServiceClickParamDTO) {
        if (updateServiceClickParamDTO == null
                || updateServiceClickParamDTO.getServiceId() == null
                || updateServiceClickParamDTO.getUserId() == null) {
            return buildResultJson(400, "PARAM_NULL", null);
        }
        return buildResultJson(200, null, null);
    }
}
