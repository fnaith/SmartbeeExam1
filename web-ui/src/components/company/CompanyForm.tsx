import React from 'react';
import Button from '@material-ui/core/Button';

import global_data from '../../store/global_data';

import CompanyFormName from './CompanyFormName';
import CompanyFormAddress from './CompanyFormAddress';

interface Props {
  index: number;
}

function CompanyForm(props: Props) {
  const { index } = props;

  const onClick = (event: any) => {
    global_data.removeCompanyForm(index);
    global_data.updateControlPanel();
  };

  return (
    <div>
      <CompanyFormName index={index} />
      <CompanyFormAddress index={index} />
      <Button variant="contained" color="primary" onClick={onClick}>
        Remove
      </Button>
    </div>
  );
}

export default CompanyForm;
