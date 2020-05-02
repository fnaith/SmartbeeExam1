import React from 'react';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function ClientInfoCompanyId(props: Props) {
  const { index } = props;

  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleClick = (event: any) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = (companyId: string) => {
    return () => {
      setAnchorEl(null);
      console.log(companyId);
      global_data.clientInfos[index].companyId = Number(companyId);
      global_data.updateControlPanel();
    }
  };

  const companyInfos = ((0 < global_data.companyInfos.length) ? global_data.companyInfos : [{id: -1}]);
  const companyIds = companyInfos.map((companyInfo: any, i: number) =>
    <MenuItem onClick={handleClose(companyInfo.id)} key={index + '-company-id-' + companyInfo.id}>
      {global_data.getCompanyName(companyInfo.id)}</MenuItem>);

  return (
    <div>
      <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
        {global_data.getCompanyName(global_data.clientInfos[index].companyId)}
      </Button>
      <Menu
        id={'simple-menu-' + index}
        anchorEl={anchorEl}
        keepMounted
        open={Boolean(anchorEl)}
        onClose={handleClose}
      >
        {companyIds}
      </Menu>
    </div>
  );
}

export default ClientInfoCompanyId;
