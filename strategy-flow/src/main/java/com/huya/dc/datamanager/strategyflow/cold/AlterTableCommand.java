package com.huya.dc.datamanager.strategyflow.cold;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlterTableCommand implements Command {
    private final static Logger logger = LoggerFactory.getLogger(AlterTableCommand.class);
    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Alter table");
        return false;
    }
}
