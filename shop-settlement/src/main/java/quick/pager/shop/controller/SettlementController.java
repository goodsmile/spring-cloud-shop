package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.SettlementService;

/**
 * 订单清结算
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.SETTLEMENT)
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    /**
     * 清结算<br />
     * 此接口生成订单，生成的用户支付金额以及支付给商户的金额<br />
     *
     * @param cartId 支付购买的购物车Id
     */
    @RequestMapping("/{cartId}")
    public Response settlement(@PathVariable("cartId") Long cartId) {
        BaseDTO dto = new BaseDTO();
        dto.setId(cartId);
        return settlementService.doService(dto);
    }

}
