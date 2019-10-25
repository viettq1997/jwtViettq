package com.iist.vse900.controller;

import com.iist.vse900.controller.base.BaseController;
import com.iist.vse900.domain.dto.NotifyDTO;
import com.iist.vse900.domain.model.Notify;
import com.iist.vse900.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notify")
public class NotifyController extends BaseController {

    @Autowired
    private NotifyService notifyService;

    @CrossOrigin
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getAllNotify() {
        List<NotifyDTO> list = notifyService.getAllNotify();
        if (list.isEmpty()) {
            return buildResultJson(204, "No content!", null);
        }
        return buildResultJson(200, "get list success", list);
    }

    @CrossOrigin
    @RequestMapping(value = "saveNotify", method = RequestMethod.POST)
    public ResponseEntity saveNotify(@RequestBody Notify notify) {
        notifyService.Save(notify);
        return buildResultJson(201, "save Notify success", null);
    }

    @CrossOrigin
    @RequestMapping(value = "deleteNotify", method = RequestMethod.DELETE)
    public ResponseEntity saveNotify(@RequestParam int id) {
        notifyService.Delete(id);
        return buildResultJson(200, "delete Notify success", null);
    }

    @CrossOrigin
    @RequestMapping(value = "updateNotify", method = RequestMethod.PUT)
    public ResponseEntity updateNotify(@RequestParam int id, @RequestBody Notify notify) {
        notifyService.Update(id, notify);
        return buildResultJson(200, "update Notify success", null);
    }
}
