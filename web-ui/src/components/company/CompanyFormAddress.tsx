import React from 'react';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function CompanyFormAddress(props: Props) {
  const { index } = props;

  const onChange: any = (event: any) => {
    const input: string = event.target.value;

    global_data.companyForms[index].address = input;
  };

  return (
    <TextField id={'companyForm-address-' + index} label="Address"
      defaultValue={global_data.companyForms[index].address} margin="dense" onChange={onChange}/>
  );
}

export default CompanyFormAddress;
