import React, { useState } from 'react';

import global_data from '../store/global_data';

import SelectTabs from './SelectTabs';
import SelectTab from './SelectTab';
import SelectPanel from './SelectPanel';
import CreateCompany from './company/CreateCompany';
import CompanyControl from './company/CompanyControl';
import CreateClient from './client/CreateClient';
import ClientControl from './client/ClientControl';
import Logout from './Logout';

const ControlPanel = function () {
  const [flag, setFlag] = useState(true);
  global_data.updateControlPanel = () => setFlag(!flag);
  global_data.init();

  const [tabValue, setTabValue] = useState(0);

  const handleChange = (event: React.ChangeEvent<{}>, value: number) => {
    setTabValue(value);
  };

  return (
    <div>
      <SelectTabs
        value={tabValue}
        onChange={handleChange}
        variant="scrollable"
        scrollButtons="auto"
        indicatorColor="primary"
        textColor="primary"
      >
        <SelectTab label="Create Company" key={'select-tab-create-companyst'}/>
        <SelectTab label="Company Control" key={'select-tab-companyst-control'}/>
        <SelectTab label="Create Client" key={'select-tab-create-client'}/>
        <SelectTab label="Client Control" key={'select-tab-client-control'}/>
        <SelectTab label="Option" key={'select-tab-option'}/>
      </SelectTabs>
      <SelectPanel expanded={tabValue === 0}>
        <CreateCompany />
      </SelectPanel>
      <SelectPanel expanded={tabValue === 1}>
        <CompanyControl />
      </SelectPanel>
      <SelectPanel expanded={tabValue === 2}>
        <CreateClient />
      </SelectPanel>
      <SelectPanel expanded={tabValue === 3}>
        <ClientControl />
      </SelectPanel>
      <SelectPanel expanded={tabValue === 4}>
        <Logout />
      </SelectPanel>
    </div>
  )
}

ControlPanel.whyDidYouRender = true;

export default ControlPanel;
