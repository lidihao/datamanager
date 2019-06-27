package com.huya.dc.datamanager.strategyflow.cold;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class CheckCRCResultCommand implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Check CRC Result");
        return false;
    }
}
